import { Component, OnInit } from '@angular/core';
import {HttpServiceService} from '../http-service.service';
import {TranslateService} from '@ngx-translate/core';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

 
  constructor(private http:HttpServiceService,private translate: TranslateService) { }

  transactionList = []; 
  notransaction= false;
  sendAmountToServer = {"amt":"","to_acc_no":""}
  ngOnInit() {
      this.loadTransactionDetails();
      this.translate.setDefaultLang("en");
  }

  changelang(type){
    this.translate.setDefaultLang(type.target.value);
  }

  sendAmount(){
    if(this.sendAmountToServer.amt == ""){
        alert("Amount should not be empty");
      return ;
    }else if(this.sendAmountToServer.to_acc_no == ""){
      alert("To Acc No should not be empty");
      return ;
    }
    let amt = this.sendAmountToServer.amt;
    let to_acc_no = this.sendAmountToServer.to_acc_no
    let request = {"amount":amt,"to_acc_no":to_acc_no}
    this.http.postRequestWithUserId('api/sendAmounToAccount',request).subscribe((data:any)=>{
      if(data.length > 0){
        this.transactionList = data;
        this.notransaction = false;
      }
      else{
        this.notransaction = true;
      }
    })
  }
  
  loadTransactionDetails(){
    this.http.postRequestWithUserId('api/getAllTransactionByUserId',{}).subscribe((data:any)=>{
      if(data.length > 0){
        this.transactionList = data;
        this.notransaction = false;
      }
      else{
        this.notransaction = true;
      }
    })
  }
}
