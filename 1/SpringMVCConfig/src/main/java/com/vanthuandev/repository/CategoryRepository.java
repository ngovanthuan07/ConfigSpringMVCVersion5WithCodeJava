/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vanthuandev.repository;

import com.vanthuandev.pojos.Category;
import java.util.List;

/**
 *
 * @author ngova
 */
public interface CategoryRepository {
    List<Category> getCategories();
}
