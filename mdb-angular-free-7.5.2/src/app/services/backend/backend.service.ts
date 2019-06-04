import {Injectable} from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { map } from 'rxjs/operators';
import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {AppSettings} from 'src/app/app.settings';

@Injectable({providedIn: 'root'})
export class BackendService {

  baseUrl = AppSettings.BASE_URL;

  constructor(private http: Http) { }

  getAll(url: string): Observable<any> {
    return this.http.get(this.baseUrl + url)
      .pipe(map(response => response));
  }

  post(url: string, object: any): Observable<any> {
    return this.create(url, object);
  }

  create(url: string, object: any): Observable<any> {
    return this.http.post(this.baseUrl + url, JSON.stringify(object))
    .pipe(map(response => response));
  } 
}