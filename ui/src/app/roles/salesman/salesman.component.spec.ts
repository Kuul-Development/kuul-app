import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalesmanComponent } from './salesman.component';

describe('SalesmanComponent', () => {
  let component: SalesmanComponent;
  let fixture: ComponentFixture<SalesmanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalesmanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalesmanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
