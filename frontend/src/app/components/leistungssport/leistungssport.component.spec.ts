import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeistungssportComponent } from './leistungssport.component';

describe('LeistungssportComponent', () => {
  let component: LeistungssportComponent;
  let fixture: ComponentFixture<LeistungssportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeistungssportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeistungssportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
