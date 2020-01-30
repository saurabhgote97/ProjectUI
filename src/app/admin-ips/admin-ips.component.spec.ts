import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminIPSComponent } from './admin-ips.component';

describe('AdminIPSComponent', () => {
  let component: AdminIPSComponent;
  let fixture: ComponentFixture<AdminIPSComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminIPSComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminIPSComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
