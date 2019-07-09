import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { BackendService } from '../../services/backend/backend.service';
import {CityDto} from '../../model/CityDto';
import { AddressDto } from 'src/app/model/AddressDto';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{

  cities: CityDto[];
  addresses: AddressDto[];

  ngOnInit() {
    this.loadAllCities();
    this.loadAllAddresses();
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
  loadAllAddresses() {
    this.backend.getAll("Addresses/").subscribe(
      (data) => {
        this.addresses = data.json() as AddressDto[];
        console.log(JSON.stringify(this.addresses));
      }
    );
  }

}
