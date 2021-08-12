package com.crm.qa.test;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListConcept {

    public static void main(String args[]) {

        int a[] = new int[4];
        ArrayList ar = new ArrayList();
        ar.add(100);
        ar.add(200);
        ar.add("Tom");
        System.out.println(ar.size());
        System.out.println(ar.get(2));
        ar.remove(1);
        for(int i=0;i<ar.size();i++)
        {
            System.out.println(ar.get(i));
        }

        Employee e1= new Employee("Alpi",30,"computers");
        Employee e2= new Employee("Nick",34,"SCience");
        Employee e3= new Employee("Mike",35,"Arts");

        ArrayList<Employee> ar2= new ArrayList<Employee>();
        ar2.add(e1);
        ar2.add(e2);
        ar2.add(e3);
        //iterator to traverse the values
        Iterator<Employee> it= ar2.iterator();
        while(it.hasNext())
        {
            Employee emp=it.next();
            System.out.println(emp.name);
            System.out.println(emp.age);
            System.out.println(emp.dept);

        }



    }
}

