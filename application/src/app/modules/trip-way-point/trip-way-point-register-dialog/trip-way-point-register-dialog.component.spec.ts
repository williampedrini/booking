import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TripWayPointRegisterDialogComponent} from './trip-way-point-register-dialog.component';

describe('TripWayPointRegisterDialogComponent', () => {
    let component: TripWayPointRegisterDialogComponent;
    let fixture: ComponentFixture<TripWayPointRegisterDialogComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [TripWayPointRegisterDialogComponent]
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(TripWayPointRegisterDialogComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
