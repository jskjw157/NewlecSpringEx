package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/* 스프링에게 지시하는 방법으로 코드를 변경
		 * Exam exam = new NewlecExam();
		 * ExamConsole console = new GridExamConsole(); 
		 * console.setExam(exam);
		 */
		
		// ApplicationContext는 인터페이스
		// ClassPathXmlApplicationContext가 상속받아 ClassPath를 지정해주면 되는 클래스
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		
		//context.getBean에서 빈객체를 갖고올경우 객체형식으로 오기때문에 형변화를 해줘야된다.
		//ExamConsole console = (ExamConsole) context.getBean("console");
		
		
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());
		
		//자료형 가져오기 때문에 형변환을 할 필요가 없고, 일반적을 자주 쓰인다.
		ExamConsole console = context.getBean(ExamConsole.class);
		console.print();

	}

}
