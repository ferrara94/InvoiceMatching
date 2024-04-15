import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliveryLineItemComponent } from './delivery-line-item.component';

describe('DeliveryLineItemComponent', () => {
  let component: DeliveryLineItemComponent;
  let fixture: ComponentFixture<DeliveryLineItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeliveryLineItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeliveryLineItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
