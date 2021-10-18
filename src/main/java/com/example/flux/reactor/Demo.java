package com.example.flux.reactor;

import com.example.flux.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-10-15 11:19
 **/
public class Demo {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1,2,3);
        flux.subscribe(System.out::println);
        Mono.just(1);

    }

    public static void test1(){
        Employee employee = new Employee();
        Consumer<String> stringConsumer = employee::setName;
        stringConsumer.accept("aaaa");
        Supplier<String> stringSupplier = employee::getName;
        stringSupplier.get();
        Function<Employee,String> f = Employee::getName;
        f.apply(employee);
        Function<Double ,Long> function = Math::round;
        function.apply(1.2);

        Comparator<Integer> comparator1 = (s1,s2)->s1.compareTo(s2);
        comparator1.compare(1,2);
        Comparator<Integer> comparator2 = Integer::compareTo;
        comparator2.compare(2,1);
    }
}
