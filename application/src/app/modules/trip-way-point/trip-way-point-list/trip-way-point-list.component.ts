import {Component, Input, OnInit} from '@angular/core';
import TripWayPoint from '../../../core/models/TripWayPoint';

@Component({
    selector: 'app-trip-way-point-list',
    templateUrl: './trip-way-point-list.component.html',
    styleUrls: ['./trip-way-point-list.component.scss']
})
export class TripWayPointListComponent implements OnInit {

    public displayedColumns: string[] = [
        'index',
        'locality',
        'lat',
        'lng',
        'tripWayPointTimestamp',
        'lastStop'
    ];

    @Input()
    public readOnly: boolean;

    @Input()
    public tripWayPoints: TripWayPoint[] = [];

    ngOnInit(): void {
        if (!this.readOnly) {
            this.displayedColumns.push('deleteAction');
        }
    }

    onDeleteClick(event: Event, index: number): void {
        this.tripWayPoints.splice(index, 1);
        this.tripWayPoints = [...this.tripWayPoints];
        event.preventDefault();
    }
}
