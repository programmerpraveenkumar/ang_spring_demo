import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {IndexComponent} from './index/index.component';
import {LoginregisterComponent} from './loginregister/loginregister.component';
const routes: Routes = [
  {path: '', component: LoginregisterComponent},
  {path: 'index', component: IndexComponent},
  {path: 'login', component: LoginregisterComponent}  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
