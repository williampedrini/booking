import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TripWayPointListComponent} from './trip-way-point-list.component';

describe('TripWayPointListComponent', () => {
    let component: TripWayPointListComponent;
    let fixture: ComponentFixture<TripWayPointListComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [TripWayPointListComponent]
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(TripWayPointListComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
