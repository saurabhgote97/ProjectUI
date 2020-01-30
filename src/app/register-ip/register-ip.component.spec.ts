import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterIpComponent } from './register-ip.component';

describe('RegisterIpComponent', () => {
  let component: RegisterIpComponent;
  let fixture: ComponentFixture<RegisterIpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterIpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterIpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
