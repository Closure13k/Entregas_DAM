/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package department.controller;

import department.Department;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AaronFM
 */
public class DepartmentController {

    public static List<Department> generateSample() {
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            departments.add(new Department(i, "Dept" + i, "Loc" + i));
        }
        return departments;
    }
}
