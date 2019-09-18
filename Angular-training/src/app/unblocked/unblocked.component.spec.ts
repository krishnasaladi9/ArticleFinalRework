import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnblockedComponent } from './unblocked.component';

describe('UnblockedComponent', () => {
  let component: UnblockedComponent;
  let fixture: ComponentFixture<UnblockedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnblockedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnblockedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
