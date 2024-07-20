# inventory management part 
[]<img src="https://github.com/Ohnstokk3/App_Store/blob/master/Screenshot_20240620_211435_Main_App_Store.jpg" width="200" height="400" />
<img src="https://github.com/Ohnstokk3/App_Store/blob/master/Screenshot_20240620_212346_Main_App_Store.jpg" width="200" height="400" />
<img src="https://github.com/Ohnstokk3/App_Store/blob/master/Screenshot_20240620_212402_Main_App_Store.jpg" width="200" height="400" />
# Store 

<img src="https://github.com/Ohnstokk3/App_Store/blob/master/Screenshot_20240702_192438_Main_App_Store.jpg" width="200" height="400" />
The images you see for the store are just placeholders.The end goal is to have a market place where users can buy and customize the app the way they want.

# Financial management part 

<img src="https://github.com/Ohnstokk3/App_Store/blob/master/Screenshot_20240702_193514_Main_App_Store.jpg" width="200" height="400" />
this part is that is  forecasting sales, using past data. not complete needs work version 1 
@Entity
public class MyEntity {
  @PrimaryKey
  public long id;

  @ColumnInfo(name = "last_updated")
  @TypeConverters(LocalDateTimeConverter.class)
  public LocalDateTime lastUpdated;

  // ... other fields
}
