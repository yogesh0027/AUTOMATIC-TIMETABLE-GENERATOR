/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javamini.timetable;

/**
 * Represents a subject in the timetable system
 * 
 * @author YOGESH,PRIYA,RAGHUL
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prabodhmayekar
 */
public class Subject {
    int id;
    String name;
    Teacher[] teacher;
    int noteachers;

    Subject() {
        teacher = new Teacher[20];
    }

    static String getSubjectName(String id) {
        DatabaseConnection db = new DatabaseConnection();
        ResultSet rs = db.executeQuery("SELECT * FROM Subject WHERE SubId = '" + id + "'");
        try {
            if (rs.next()) {
                return rs.getString("SubName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "No_Name_Fround";
    }

    static String getSubjectId(String Name) {
        DatabaseConnection db = new DatabaseConnection();
        ResultSet rs = db.executeQuery("SELECT * FROM Subject WHERE SubName = '" + Name + "'");
        try {
            if (rs.next()) {
                return rs.getString("SubId");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "No_Name_Found";
    }
}
