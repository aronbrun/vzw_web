import { Component} from '@angular/core';
import { environment } from 'src/environments/environment';
import {AppSettings} from './app.settings';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'app';

  constructor() { }

}
