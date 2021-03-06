package com.example.goingroguedesign.utils;

import android.content.Context;
import com.example.goingroguedesign.R;

import java.util.Random;

public class GetRandString {

    Context context;
    public GetRandString(Context ct) {
        context = ct;
    }

    public String getFirstName () {
        String[] array = context.getResources().getStringArray(R.array.random_first_names);
        String s = array[new Random().nextInt(array.length)];
        return s;
    }

    public String getLastName () {
        String[] array = context.getResources().getStringArray(R.array.random_last_names);
        String s = array[new Random().nextInt(array.length)];
        return s;
    }

    public String getRandAddress () {
        String[] dir = {"N", "E", "S", "W", "SE", "SW", "NW", "NE"};
        String[] type = {"ST", "AVE", "PKWY", "PL", "DR", "RD", "BLVD", "LN"};
        String[] street = context.getResources().getStringArray(R.array.random_last_names);
        String[] city = context.getResources().getStringArray(R.array.random_city_names);
        String[] state = context.getResources().getStringArray(R.array.state_arrays);
        String s1 = street[new Random().nextInt(street.length)];
        String s2 = dir[new Random().nextInt(dir.length)];
        String s3 = type[new Random().nextInt(type.length)];
        String s4 = city[new Random().nextInt(city.length)];
        String s5 = state[new Random().nextInt(state.length)];
        int i1 = new Random().nextInt(10000 - 1);
        int i2 = new Random().nextInt(100000 - 10000) +10000;

        return (i1 + " " + s2 + " " + s1 + " " + s3 + ", " + s4 + ", " + s5 + " " + i2);
    }

    public String getHotel () {
        String[] h = context.getResources().getStringArray(R.array.random_hotel_names);
        String s = h[new Random().nextInt(h.length)];
        return s;
    }

    public String getStatus () {
        String[] strings = {"New", "Started", "Completed", "Closed"};
        String string = strings[new Random().nextInt(strings.length)];
        return string;
    }

    public String getPhoneNumber () {
        int i1 = new Random().nextInt(1000 - 100) +100;
        int i2 = new Random().nextInt(10000000 - 1000000) +1000000;
        return (i1 +""+ i2);
    }

    public String getEmail () {
        String[] strings = {"gmail", "yahoo", "hotmail", "aol", "outlook", "gmail", "gmail"};
        String[] a1 = context.getResources().getStringArray(R.array.random_last_names);
        String[] a2 = context.getResources().getStringArray(R.array.random_last_names);
        String s1 = a1[new Random().nextInt(a1.length)];
        String s2 = a2[new Random().nextInt(a2.length)];
        String s3 = strings[new Random().nextInt(strings.length)];

        return (s1 + s2 + "@" + s3 + ".com");
    }

    public String getContractorType () {
        String[] a1 = context.getResources().getStringArray(R.array.contractor_type_arrays);
        String s1 = a1[new Random().nextInt(a1.length)];

        return s1;
    }

    public String getContent () {
        String[] a1 = context.getResources().getStringArray(R.array.random_content);
        String s1 = a1[new Random().nextInt(a1.length)];

        return s1;
    }
}
