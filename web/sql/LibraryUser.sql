/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Alexis Padula and Sean Webber
 * Created: Dec 5, 2016
 */

CREATE TABLE LibraryUsers(
    UserIndex INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(25) NOT NULL,
    LastName  VARCHAR(30) NOT NULL,
    Email VARCHAR(40) NOT NULL,
    Title VARCHAR(60) NOT NULL,
    DueDate DATE);
    
    
