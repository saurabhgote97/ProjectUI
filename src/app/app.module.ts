import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { HttpClientModule } from '@angular/common/http';
import { ContactComponent } from './contact/contact.component';
import { RegisterComponent } from './register/register.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { RouterModule } from '@angular/router';
import {NgModel, FormsModule, NgForm} from '@angular/forms';
import { AuthService } from './auth.service';
import { LoginComponent } from './login/login.component';
import { StudentDashboardComponent } from './student-dashboard/student-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { InstitutePersonDashboardComponent } from './institute-person-dashboard/institute-person-dashboard.component';
import { InstChangePasswordComponent } from './inst-change-password/inst-change-password.component';
import { InstEditProfileComponent } from './inst-edit-profile/inst-edit-profile.component';
import { StuEditProfileComponent } from './stu-edit-profile/stu-edit-profile.component';
import { StuChangePasswordComponent } from './stu-change-password/stu-change-password.component';
import { ShowTestComponent } from './show-test/show-test.component';
//import { TakeTestComponent } from './take-test/take-test.component';
import { StuTestHistoryComponent } from './stu-test-history/stu-test-history.component';
import { StuShowReportComponent } from './stu-show-report/stu-show-report.component';
import { LatestResultComponent } from './latest-result/latest-result.component';
import { AdminEditProfileComponent } from './admin-edit-profile/admin-edit-profile.component';
import { AdminChangePasswordComponent } from './admin-change-password/admin-change-password.component';
import { TakeTestComponent } from './take-test/take-test.component';
import { RegisterStudentComponent } from './register-student/register-student.component';
import { RegisterIpComponent } from './register-ip/register-ip.component';
import { CreateTestComponent } from './create-test/create-test.component';
import { CreateQuestionComponent } from './create-question/create-question.component';
import { DesignTestComponent } from './design-test/design-test.component';
import { AddQuestionToTestComponent } from './add-question-to-test/add-question-to-test.component';
import { AdminShowTestsComponent } from './admin-show-tests/admin-show-tests.component';
import { AdminStudentsComponent } from './admin-students/admin-students.component';
import { AdminIPSComponent } from './admin-ips/admin-ips.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutusComponent,
    ContactComponent,
    RegisterComponent,
    NotfoundComponent,
    LoginComponent,
    StudentDashboardComponent,
    AdminDashboardComponent,
    InstitutePersonDashboardComponent,
    StuEditProfileComponent,
    StuChangePasswordComponent,
    InstChangePasswordComponent,
    InstEditProfileComponent,
    ShowTestComponent,
    TakeTestComponent,
    StuTestHistoryComponent,
    StuShowReportComponent,
    LatestResultComponent,
    AdminEditProfileComponent,
    AdminChangePasswordComponent,
    RegisterStudentComponent,
    RegisterIpComponent,
    CreateTestComponent,
    CreateQuestionComponent,
    DesignTestComponent,
    AddQuestionToTestComponent,
    AdminShowTestsComponent,
    AdminStudentsComponent,
    AdminIPSComponent,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot([
  // { path: "", component: HomeComponent , canActivate:[AuthService]}, 
   { path: "home", component: HomeComponent  , canActivate:[AuthService]},
     { path: "register", component: RegisterComponent},
     { path: "about", component: AboutusComponent },
     { path: "contact", component: ContactComponent },
     { path: "login", component: LoginComponent },
     { path: "register-student", component: RegisterStudentComponent },
     { path: "register-ip", component: RegisterIpComponent },
     { path:'home',component:HomeComponent,children:[ {path: 'studentDashboard',component:StudentDashboardComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'studentEditProfile',component:StuEditProfileComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'studentChangePassword',component:StuChangePasswordComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'studentShowTest',component:ShowTestComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'studentTakeTest/:No',component:TakeTestComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'latestResult',component:LatestResultComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'studentTakeHistory',component:StuTestHistoryComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'studentShowReport',component:StuShowReportComponent}],canActivate:[AuthService]},
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     { path:'home',component:HomeComponent,children:[ {path: 'adminDashboard',component:AdminDashboardComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'adminChangePassword',component:AdminChangePasswordComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'adminEditProfile',component:AdminEditProfileComponent}],canActivate:[AuthService]}, 
     { path:'home',component:HomeComponent,children:[ {path: 'adminShowTest',component:AdminShowTestsComponent}],canActivate:[AuthService]}, 
     { path:'home',component:HomeComponent,children:[ {path: 'adminShowStudents',component:AdminStudentsComponent}],canActivate:[AuthService]}, 
     { path:'home',component:HomeComponent,children:[ {path: 'adminShowIPS',component:AdminIPSComponent}],canActivate:[AuthService]}, 
    
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     { path:'home',component:HomeComponent,children:[ {path: 'instutiteEditProfile',component:InstEditProfileComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'instutiteChangePassword',component:InstChangePasswordComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'institutePersonDashboard',component:InstitutePersonDashboardComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'designTest',component:DesignTestComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'createTest',component:CreateTestComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'createQuestion',component:CreateQuestionComponent}],canActivate:[AuthService]},
     { path:'home',component:HomeComponent,children:[ {path: 'addQuestionToTest/:id',component:AddQuestionToTestComponent}],canActivate:[AuthService]},     
     { path: "**", component: HomeComponent,canActivate:[AuthService] }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule 
{
  constructor()
  {
    console.log("App Module Created");
  }
}