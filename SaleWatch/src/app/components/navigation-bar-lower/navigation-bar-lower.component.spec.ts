import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigationBarLowerComponent } from './navigation-bar-lower.component';

describe('NavigationBarLowerComponent', () => {
  let component: NavigationBarLowerComponent;
  let fixture: ComponentFixture<NavigationBarLowerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavigationBarLowerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavigationBarLowerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
