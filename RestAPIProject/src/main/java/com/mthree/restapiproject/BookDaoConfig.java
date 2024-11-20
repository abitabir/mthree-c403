/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.restapiproject;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author khali
 */

@Setter
@Getter
@Configuration

@ConfigurationProperties(prefix="spring.datasource")
public class BookDaoConfig {
    private String driver;
    private String url;
    private String username;
    private String password;
    private String databaseName;
    private String tableName;
}
