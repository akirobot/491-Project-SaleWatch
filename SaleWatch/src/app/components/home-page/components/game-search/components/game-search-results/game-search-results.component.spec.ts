import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GameSearchResultsComponent } from './game-search-results.component';

describe('GameSearchResultsComponent', () => {
  let component: GameSearchResultsComponent;
  let fixture: ComponentFixture<GameSearchResultsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GameSearchResultsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GameSearchResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
