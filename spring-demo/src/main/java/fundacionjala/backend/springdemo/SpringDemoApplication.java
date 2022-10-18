package fundacionjala.backend.springdemo;

import fundacionjala.backend.springdemo.models.User;
import fundacionjala.backend.springdemo.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpringDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringDemoApplication.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringDemoApplication.class);
		UserService service = context.getBean("userService", UserService.class);
		User u = service.findAll().get(0);
		System.out.println(u.getFirstName());

//		String[] array = new String[5];// [null, null, null, null, null]
//		array[3] = "hello world"; // [null, null, null, "hello world", null]
//
////		if (Optional.ofNullable(array[3]).isPresent()) {
////			System.out.println(Optional.of(array[3]).get());
////		}
//
//		//Streams??
//		List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9);
//		var pairNumbers = numberList.stream().filter(n -> n % 2 == 0 && n/2 == 1).collect(Collectors.toList());
//		//pairNumbers.stream().forEach(n -> System.out.println(n));
//
//		Stream<Integer> streamInt = Stream.of(1,2,3,4,5,6,7,8,9);
//		Map<Integer,Integer> numbers = streamInt.collect(Collectors.toMap(n -> n, n -> n*2));
//
//		//Predicate java8
//		Predicate<Integer> impairPredicate = n -> n % 2 != 0;
//		Predicate<Integer> greaterThan5 = n -> n > 5;
//
//		List<Integer> numberList2 = Arrays.asList(1,2,3,4,5,6,7,8,9);
//		var pairNumbers2 = numberList2.stream()
//				.filter(impairPredicate.and(greaterThan5))
//				.collect(Collectors.toList());
//
//		pairNumbers2.stream().forEach(n -> System.out.println(n));
//
//		// streams framework, common filters, aggregation methods
	}

}
