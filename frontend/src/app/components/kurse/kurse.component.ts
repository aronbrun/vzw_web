import { Component, OnInit } from '@angular/core';
import { CourseDto } from '../../model/CoursesDto';
import { BackendService } from '../../services/backend/backend.service';

@Component({
  selector: 'app-kurse',
  templateUrl: './kurse.component.html',
  styleUrls: ['./kurse.component.scss']
})
export class KurseComponent implements OnInit {
  kurse: CourseDto[];
  constructor(private backend: BackendService) { }
  loadAllKurse() {
    this.backend.getAll("Courses/").subscribe(
      (data) => {
        this.kurse = data.json() as CourseDto[];
        console.log(JSON.stringify(this.kurse));
      }
    );
  }
  ngOnInit() {
    this.loadAllKurse();
  }

}
