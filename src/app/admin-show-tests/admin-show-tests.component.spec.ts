import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminShowTestsComponent } from './admin-show-tests.component';

describe('AdminShowTestsComponent', () => {
  let component: AdminShowTestsComponent;
  let fixture: ComponentFixture<AdminShowTestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminShowTestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminShowTestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
