import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http'; 
import { HttpModule } from '@angular/http';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './components/home/home.component';
import { LeistungssportComponent } from './components/leistungssport/leistungssport.component';
import { BreitensportComponent } from './components/breitensport/breitensport.component';
import { VereinComponent } from './components/verein/verein.component';
import { KurseComponent } from './components/kurse/kurse.component';

const appRoutes: Routes = [
  {
      path: 'home',
      component: HomeComponent
  },
  {
    path: 'leistungssport',
    component: LeistungssportComponent
},
{
  path: 'breitensport',
  component: BreitensportComponent
},
{
  path: 'verein',
  component: VereinComponent
},
{
path: 'kurse',
component: KurseComponent
}];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LeistungssportComponent,
    BreitensportComponent,
    VereinComponent,
    KurseComponent
  ],
  imports: [
    HttpModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
