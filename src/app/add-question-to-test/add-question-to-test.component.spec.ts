import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddQuestionToTestComponent } from './add-question-to-test.component';

describe('AddQuestionToTestComponent', () => {
  let component: AddQuestionToTestComponent;
  let fixture: ComponentFixture<AddQuestionToTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddQuestionToTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddQuestionToTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
