package java03.test01;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java03.test01.annotation.Command;
import java03.test01.annotation.Component;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

public class BoardApp {

	static class CommandInfo {
		Object object;
		Method method;
	}

	Scanner scanner = new Scanner(System.in);
	BoardDao boardDao;
	HashMap<String, CommandInfo> componentMap = new HashMap<String, CommandInfo>();

	public void init() throws Exception {
		// 프로그램 로드 준비
		boardDao = new BoardDao();
		CommandInfo commandInfo;
		// DAO 인스턴스화
		// 갖다 쓸 수 있게 각 클래스의 객체 생성 및 객체 풀에 넣기
		// componentMap = 키와 객체를 넣는다

		Reflections reflections = new Reflections("java03.test01");

		Object objClazz;
		Command command;
		Method method;

		Set<Class<?>> clazzes = reflections
				.getTypesAnnotatedWith(Component.class);

		for (Class clazz : clazzes) {
			System.out.println("클래스로딩 테스트: " + clazz.getName());
			objClazz = clazz.newInstance();

			Set<Method> methods = ReflectionUtils.getMethods(clazz,ReflectionUtils.withAnnotation(Command.class));

			for (Method m : methods) {
				commandInfo = new CommandInfo();
				commandInfo.object = objClazz;
				commandInfo.method = m;
				command = m.getAnnotation(Command.class);
				System.out.println("메소드로딩 테스트: " + m.getName());
				System.out.println("어노테이션 value 값 로드:" + command.value());

				componentMap.put(command.value(), commandInfo);
			}

			try {

				method = clazz.getMethod("setBoardDao", BoardDao.class);
				method.invoke(objClazz, boardDao);

				method = clazz.getMethod("setScanner", Scanner.class);
				method.invoke(objClazz, scanner);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void service() throws Exception {


		CommandInfo commandInfo;
		try{
		
		loop:
		while (true) {

			String[] promp = promp();
//			System.out.println(promp[0]);
			
			commandInfo = componentMap.get(promp[0]);
			
			
			if(promp[0].equalsIgnoreCase("exit")){
				System.out.println("???");
				break loop;
			}

			if(commandInfo==null){
				System.out.println("지원하지 않는 명령어 입니다.");
				continue;
			}
			
//			System.out.println(commandInfo.method.getName());
			
			ArrayList<String> inputParams = new ArrayList<String>();
			
			for(int i =1; i<promp.length;i++){
				inputParams.add(promp[i]);
			}
			
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("inputParams", inputParams);
			commandInfo.method.invoke(commandInfo.object,params);

		
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void destroy() {
		scanner.close();
	}

	private String[] promp() {
		System.out.print(">");
		String arr[] = scanner.nextLine().split(" ");
		return arr;
	}

	public static void main(String[] args) throws Exception {

		BoardApp app = new BoardApp();
		app.init();
		app.service();
		app.destroy();

	}
}
