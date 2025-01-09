package com.example.MyAppleStore.repositories;

import com.example.MyAppleStore.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>  //TODO Product - объект, с которым работаем, Long - тип ID , с помощью этой команды наследуем методы удаления из БД, добавление в БД и т.д
{
    List<Product> findByTitle(String title); // TODO ищем товары по названию

}
