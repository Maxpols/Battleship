class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        ++this.minutes;
        //when 60 minutes have expired the hour increments by one, if not. it continues it's business
        switch (this.minutes) {
            case 60:
                this.minutes = 0;
                this.hours++;
                break;
            default:
        }

        switch (this.hours) {
            case 13:
                this.hours = 1;
                break;
            default:
        }
        }
    }

