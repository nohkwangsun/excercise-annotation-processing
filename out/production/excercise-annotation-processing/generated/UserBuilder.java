package org.pieuler.domain;
public class UserBuilder{
public static UserBuilder create(){
return new UserBuilder();}

private User object;
private UserBuilder(){
this.object = new User();}
public User build(){return this.object;}
}