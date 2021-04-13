import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class OlympixMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    public static int MAP_KEY;
    public static int MAP_VALUE;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String transaction = value.toString();
        String[] colones = transaction.split(",");
        Configuration conf = context.getConfiguration();
        OlympixMapper.MAP_KEY = conf.getInt("MAP_KEY", 5);
        OlympixMapper.MAP_VALUE = conf.getInt("MAP_VALUE", 9);
        String discipline = colones[OlympixMapper.MAP_KEY];
        int nombreMedailles = Integer.parseInt(colones[OlympixMapper.MAP_VALUE]);
        context.write(new Text(discipline), new IntWritable(nombreMedailles));
    }


}
