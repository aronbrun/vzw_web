import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { BackendService } from '../../services/backend/backend.service';
import {CityDto} from '../../model/CityDto';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{

  cities: CityDto[];

  ngOnInit() {
    this.loadAllCities();
  }
  constructor(private backend: BackendService) { }

  loadAllCities() {
    this.backend.getAll("Cities/").subscribe(
      (data) => {
        this.cities = data.json() as CityDto[];
        console.log(JSON.stringify(this.cities));
      }
    );
  }

}
