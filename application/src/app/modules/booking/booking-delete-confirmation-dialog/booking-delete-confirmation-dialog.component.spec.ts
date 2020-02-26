import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {BookingDeleteConfirmationDialogComponent} from './booking-delete-confirmation-dialog.component';

describe('BookingDeleteConfirmationDialogComponent', () => {
    let component: BookingDeleteConfirmationDialogComponent;
    let fixture: ComponentFixture<BookingDeleteConfirmationDialogComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [BookingDeleteConfirmationDialogComponent]
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(BookingDeleteConfirmationDialogComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
