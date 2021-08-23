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
		
		/* ���������� �����ϴ� ������� �ڵ带 ����
		 * Exam exam = new NewlecExam();
		 * ExamConsole console = new GridExamConsole(); 
		 * console.setExam(exam);
		 */
		
		// ApplicationContext�� �������̽�
		// ClassPathXmlApplicationContext�� ��ӹ޾� ClassPath�� �������ָ� �Ǵ� Ŭ����
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		
		//context.getBean���� ��ü�� ����ð�� ��ü�������� ���⶧���� ����ȭ�� ����ߵȴ�.
		//ExamConsole console = (ExamConsole) context.getBean("console");
		
		
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());
		
		//�ڷ��� �������� ������ ����ȯ�� �� �ʿ䰡 ����, �Ϲ����� ���� ���δ�.
		ExamConsole console = context.getBean(ExamConsole.class);
		console.print();

	}

}
