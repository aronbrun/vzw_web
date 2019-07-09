import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BreitensportComponent } from './breitensport.component';

describe('BreitensportComponent', () => {
  let component: BreitensportComponent;
  let fixture: ComponentFixture<BreitensportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BreitensportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BreitensportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
