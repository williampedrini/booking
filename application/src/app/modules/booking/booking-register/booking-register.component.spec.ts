import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {BookingRegisterComponent} from './booking-register.component';

describe('BookingRegisterComponent', () => {
    let component: BookingRegisterComponent;
    let fixture: ComponentFixture<BookingRegisterComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [BookingRegisterComponent]
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(BookingRegisterComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
