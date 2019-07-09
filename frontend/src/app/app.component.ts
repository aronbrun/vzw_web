import { Component, OnInit} from '@angular/core';
import { environment } from 'src/environments/environment';
import {AppSettings} from './app.settings';
import { BackendService } from './services/backend/backend.service';
import { CityDto } from './model/CityDto';
import { MemberDto } from './model/MemberDto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent{
  title = 'app';
  member: MemberDto;

  
  constructor(private backend: BackendService) { }

  onLogin(username, password){
    if(((document.getElementById(username)as HTMLInputElement).value && document.getElementById(password)as HTMLInputElement).value) {
    this.backend.getByLogin("Members/", (document.getElementById(username)as HTMLInputElement).value, (document.getElementById(password)as HTMLInputElement).value).subscribe(
      (data) => {
        this.member = data.json() as MemberDto;
        document.getElementById("loginSuccess").style.display = 'block';
        document.getElementById("form1").style.display = 'none';
      },
      (error) => {
      document.getElementById("error").innerHTML = "Falscher Username oder Passwort"
      }
    );
    } else {
      document.getElementById("error").innerHTML = "Bitte fuelle alle Felder aus"
      }
}
}
