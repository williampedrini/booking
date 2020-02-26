export default class TripWayPoint {
    public lastStop: boolean = false;
    public locality: string;
    public lat: number;
    public lng: number;
    public tripWayPointTimestamp: Date = new Date();
}
