import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomepageComponent } from './homepage/homepage.component';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { RewardComponent } from './reward/reward.component';
import { ManagerComponent } from './manager/manager.component';
import { UserComponent } from './user/user.component';
import { TaskComponent } from './task/task.component';
import { CounterComponent } from './counter/counter.component';
import { UsertaskComponent } from './usertask/usertask.component';
const routes: Routes = [
  {path:'',component:HomepageComponent},
  {path:'login', component: LoginComponent,
  //      children:[
  //      {path: "gurgaon", component: GurgaonComponent},
  //      {path: "bangalore", component: BangaloreComponent},
  // ]
},
  {path:"signup", component: SignupComponent},
 {path:"employee", component: EmployeeComponent,},
 {path:"reward", component: RewardComponent,},
 {path:"manager", component: ManagerComponent,},
 {path:"task", component: TaskComponent,},
 {path:"counter", component: CounterComponent,},
 {path:"user", component: UserComponent,},
 {path:"usertask", component: UsertaskComponent,}

];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HeaderComponent,
    FooterComponent,
    HomepageComponent,
    EmployeeComponent,
    RewardComponent,
    ManagerComponent,
    UserComponent,
    TaskComponent,
    CounterComponent,
    UsertaskComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes),

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

