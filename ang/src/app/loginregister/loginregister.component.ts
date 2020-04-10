import { Component, OnInit } from '@angular/core';
import {HttpServiceService} from '../http-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-loginregister',
  templateUrl: './loginregister.component.html',
  styleUrls: ['./loginregister.component.css']
})
export class LoginregisterComponent implements OnInit {

  isLogin=true;
  loginForm= {"email":"","pwd":""}

  constructor(private router:Router,private http:HttpServiceService) { }

  ngOnInit() {
  }
  
  showAndHideLogin(isLogin:boolean){
    this.isLogin = isLogin;//true for login ,false for register                            
  }
  loginAPI(){
    if(this.loginForm.email == ""){
      alert("email should not be empty");
    return ;
  }else if(this.loginForm.pwd == ""){
    alert("pwd should not be empty");
    return ;
  }
    let request = {
      "email":this.loginForm.email,
      "password":this.loginForm.pwd,
    }
    this.http.postRequest('api/login',request).subscribe(data=>{
      //navigate to index component
      console.log(data);      
      this.router.navigate(['index']);
      localStorage.setItem("userId","1");
    },error=>{
      console.log(error);
      
      alert("Error while login "+error.message);
    })
  }
  registerAPI(){
    let request = {
      "email":"",
      "pass":"",
      "name":""
    }
  this.http.postRequest('api/register',request).subscribe(data=>{
      this.isLogin = true;
    },error=>{
      alert("Error while Registrtaion "+error.message);
    })
  }  
}
