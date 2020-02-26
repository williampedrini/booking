import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TripWayPointListDialogComponent} from './trip-way-point-list-dialog.component';

describe('TripWayPointListDialogComponent', () => {
    let component: TripWayPointListDialogComponent;
    let fixture: ComponentFixture<TripWayPointListDialogComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [TripWayPointListDialogComponent]
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(TripWayPointListDialogComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
