import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompaniesTrucksNewComponent } from './companies-trucks-new.component';

describe('CompaniesTrucksNewComponent', () => {
  let component: CompaniesTrucksNewComponent;
  let fixture: ComponentFixture<CompaniesTrucksNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompaniesTrucksNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompaniesTrucksNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
