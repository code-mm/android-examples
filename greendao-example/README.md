# GreenDao #


2017/12/28 20:08:27


----------

## 地址

- [http://greenrobot.org/greendao/](http://greenrobot.org/greendao/)

- [https://github.com/greenrobot/greenDAO](https://github.com/greenrobot/greenDAO)



## 介绍


### greenDAO：您的SQLite数据库的Android ORM


> greenDAO是一个开源的Android ORM，使SQLite数据库的开发再次变得有趣。它可以帮助开发人员在节省开发时间的同时处理低级别的数据库需求。SQLite是一个很棒的嵌入式关系数据库。尽管如此，编写SQL和解析查询结果是非常繁琐和耗时的任务。通过将Java对象映射到数据库表格（称为ORM，“对象/关系映射”），greenDAO将这些对象从中解放出来。这样，您可以使用简单的面向对象的API来存储，更新，删除和查询Java对象。


![](http://greenrobot.org/wordpress/wp-content/uploads/greenDAO-orm-320-300x86.png)


## greenDAO功能

### 对象/关系映射（ORM）

> greenDAO Android ORMgreenDAO的本质是为存储在关系数据库SQLite中的数据提供一个面向对象的接口。只需定义数据模型，greenDAO将创建Java数据对象（实体）和DAO（数据访问对象）。这将为您节省很多无聊的代码，只是来回移动数据。除此之外，greenDAO还提供了一些高级的ORM功能，如会话缓存，预先加载和活动实体。



### 性能

> 在我们所知的所有ORM中，greenDAO是最快的。greenDAO对性能没有任何妥协。数据库非常适合存储大量数据，因此速度很重要。使用greenDAO，大多数实体可以以每秒几千个实体的速率插入，更新和加载。
我们对greenDAO的表现充满信心，并邀请您将greenDAO与其他ORM进行比较。我们开放了我们的基准，充分透明。下面的图表比较了Android的greenDAO，OrmLite和ActiveAndroid的三种最流行的ORM解决方案（根据基于GitHub星和Appbrain的统计）。greenDAO插入和更新实体的速度提高了2倍，加载实体的速度比ORMLite快4倍。对于典型的应用来说，加载速度是最相关的。

![](http://greenrobot.org/wordpress/wp-content/uploads/greenDAO-vs-OrmLite-vs-ActiveAndroid.png)

	除了greenDAO的高性能核心之外，诸如会话缓存和智能加载技术等功能还提高了性能。

### 加密支持 ###

您可以使用嵌入在Android中的标准SQLite使用greenDAO，也可以将其与SQLCipher一起使用

### Slim library

> greenDAO’s core library is less than 100k in size, so adding greenDAO does not hurt your APK size.

> 意思是体积不到100k,不会影响程序

### 活动实体 ###

> 如果你愿意，实体可以变为“活动”：活动实体透明地解析关系（你只需要调用一个getter），并且有更新，删除和刷新方法，以方便访问持久性功能。


### 协议缓冲区支持 ###

> greenDAO允许您将协议缓冲区（protobuf）对象直接保存到数据库中。如果您通过protobuf与您的服务器通话，则不需要另外的映射。常规实体的所有持久化操作都可用于protobuf对象。我们相信这是greenDAO的独特功能。


### 代码生成 ###

> greenDAO将生成Java数据对象（实体）和DAO对象。DAO对象是针对允许最佳映射的实体定制的。
未来的计划：生成适配器，也许CRUD活动。



### 开源 ###

> greenDAO的源代码在G itHub上完全可用。源代码发行版还包含一个JUnit测试套件，它使用了greenDAO的所有功能，因此是学习greenDAO的好方法。


### 支持 ###

> greenDAO是开源的，并支持其开发者和其社区。




## 使用

### 工程 build.gradle 添加


	// In your root build.gradle file:
	buildscript {
	    repositories {
	        jcenter()
	        mavenCentral() // add repository
	    }
	    dependencies {
	        classpath 'com.android.tools.build:gradle:2.3.3'
	        classpath 'org.greenrobot:greendao-gradle-plugin:3.2.2' // add plugin
	    }
	}





### app build.gradle 添加


	// In your app projects build.gradle file:
	apply plugin: 'com.android.application'
	apply plugin: 'org.greenrobot.greendao' // apply plugin

	dependencies {
	    compile 'org.greenrobot:greendao:3.2.2' // add library
	}



### 设置代码生产的路径

	android {
	  ...
	    defaultConfig {
	      ...
	    }
	    buildTypes {
	        release {
	          ...
	        }
	    }
	    greendao {
	        schemaVersion 1
	        daoPackage 'com.maohuawei.greendaounit0.gen'//这个是生成代码保存的包名
	        targetGenDir 'src/main/java'//保存到java代码路径
	    }
	}




## 代码

### 创建实体类 ###

	import org.greenrobot.greendao.annotation.Entity;
	import org.greenrobot.greendao.annotation.Id;

	/**
	 * Created by maohuawei on 2018/1/1.
	 */

	@Entity
	public class User {


	    /**
	     * 自动增长
	     */
	    @Id(autoincrement = true)
	    private long id;

	    private String name;

	    private int age;

	    private String sex;

	    private String city;


	}

> 一般一个类对应数据库中的一张表（类名：表明，属性：字段）



### 点击Android Studio 的Build - Make Project(CTRL+F9)




### 生成的类




> 这触发greenDAO生成DAO类


- User


		import org.greenrobot.greendao.annotation.Entity;
		import org.greenrobot.greendao.annotation.Id;
		import org.greenrobot.greendao.annotation.Generated;

		/**
		 * Created by maohuawei on 2018/1/1.
		 */

		@Entity
		public class User {


		    /**
		     * 自动增长
		     */
		    @Id(autoincrement = true)
		    private Long id;

		    private String name;

		    private int age;

		    private String sex;

		    private String city;

		    @Generated(hash = 1028872473)
		    public User(Long id, String name, int age, String sex, String city) {
		        this.id = id;
		        this.name = name;
		        this.age = age;
		        this.sex = sex;
		        this.city = city;
		    }

		    @Generated(hash = 586692638)
		    public User() {
		    }

		    public Long getId() {
		        return this.id;
		    }

		    public void setId(Long id) {
		        this.id = id;
		    }

		    public String getName() {
		        return this.name;
		    }

		    public void setName(String name) {
		        this.name = name;
		    }

		    public int getAge() {
		        return this.age;
		    }

		    public void setAge(int age) {
		        this.age = age;
		    }

		    public String getSex() {
		        return this.sex;
		    }

		    public void setSex(String sex) {
		        this.sex = sex;
		    }

		    public String getCity() {
		        return this.city;
		    }

		    public void setCity(String city) {
		        this.city = city;
		    }
		}

- DaoMaster



		import android.content.Context;
		import android.database.sqlite.SQLiteDatabase;
		import android.database.sqlite.SQLiteDatabase.CursorFactory;
		import android.util.Log;

		import org.greenrobot.greendao.AbstractDaoMaster;
		import org.greenrobot.greendao.database.StandardDatabase;
		import org.greenrobot.greendao.database.Database;
		import org.greenrobot.greendao.database.DatabaseOpenHelper;
		import org.greenrobot.greendao.identityscope.IdentityScopeType;


		// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
		/**
		 * Master of DAO (schema version 1): knows all DAOs.
		 */
		public class DaoMaster extends AbstractDaoMaster {
		    public static final int SCHEMA_VERSION = 1;

		    /** Creates underlying database table using DAOs. */
		    public static void createAllTables(Database db, boolean ifNotExists) {
		        UserDao.createTable(db, ifNotExists);
		    }

		    /** Drops underlying database table using DAOs. */
		    public static void dropAllTables(Database db, boolean ifExists) {
		        UserDao.dropTable(db, ifExists);
		    }

		    /**
		     * WARNING: Drops all table on Upgrade! Use only during development.
		     * Convenience method using a {@link DevOpenHelper}.
		     */
		    public static DaoSession newDevSession(Context context, String name) {
		        Database db = new DevOpenHelper(context, name).getWritableDb();
		        DaoMaster daoMaster = new DaoMaster(db);
		        return daoMaster.newSession();
		    }

		    public DaoMaster(SQLiteDatabase db) {
		        this(new StandardDatabase(db));
		    }

		    public DaoMaster(Database db) {
		        super(db, SCHEMA_VERSION);
		        registerDaoClass(UserDao.class);
		    }

		    public DaoSession newSession() {
		        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
		    }

		    public DaoSession newSession(IdentityScopeType type) {
		        return new DaoSession(db, type, daoConfigMap);
		    }

		    /**
		     * Calls {@link #createAllTables(Database, boolean)} in {@link #onCreate(Database)} -
		     */
		    public static abstract class OpenHelper extends DatabaseOpenHelper {
		        public OpenHelper(Context context, String name) {
		            super(context, name, SCHEMA_VERSION);
		        }

		        public OpenHelper(Context context, String name, CursorFactory factory) {
		            super(context, name, factory, SCHEMA_VERSION);
		        }

		        @Override
		        public void onCreate(Database db) {
		            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
		            createAllTables(db, false);
		        }
		    }

		    /** WARNING: Drops all table on Upgrade! Use only during development. */
		    public static class DevOpenHelper extends OpenHelper {
		        public DevOpenHelper(Context context, String name) {
		            super(context, name);
		        }

		        public DevOpenHelper(Context context, String name, CursorFactory factory) {
		            super(context, name, factory);
		        }

		        @Override
		        public void onUpgrade(Database db, int oldVersion, int newVersion) {
		            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
		            dropAllTables(db, true);
		            onCreate(db);
		        }
		    }

		}


- DaoSession



		import java.util.Map;

		import org.greenrobot.greendao.AbstractDao;
		import org.greenrobot.greendao.AbstractDaoSession;
		import org.greenrobot.greendao.database.Database;
		import org.greenrobot.greendao.identityscope.IdentityScopeType;
		import org.greenrobot.greendao.internal.DaoConfig;

		import com.maohuawei.greendao_unit1.User;

		import com.maohuawei.greendao_unit1.gen.UserDao;

		// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

		/**
		 * {@inheritDoc}
		 *
		 * @see org.greenrobot.greendao.AbstractDaoSession
		 */
		public class DaoSession extends AbstractDaoSession {

		    private final DaoConfig userDaoConfig;

		    private final UserDao userDao;

		    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
		            daoConfigMap) {
		        super(db);

		        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
		        userDaoConfig.initIdentityScope(type);

		        userDao = new UserDao(userDaoConfig, this);

		        registerDao(User.class, userDao);
		    }

		    public void clear() {
		        userDaoConfig.clearIdentityScope();
		    }

		    public UserDao getUserDao() {
		        return userDao;
		    }

		}


- UserDao



		import android.database.Cursor;
		import android.database.sqlite.SQLiteStatement;

		import org.greenrobot.greendao.AbstractDao;
		import org.greenrobot.greendao.Property;
		import org.greenrobot.greendao.internal.DaoConfig;
		import org.greenrobot.greendao.database.Database;
		import org.greenrobot.greendao.database.DatabaseStatement;

		import com.maohuawei.greendao_unit1.User;

		// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
		/**
		 * DAO for table "USER".
		*/
		public class UserDao extends AbstractDao<User, Long> {

		    public static final String TABLENAME = "USER";

		    /**
		     * Properties of entity User.<br/>
		     * Can be used for QueryBuilder and for referencing column names.
		     */
		    public static class Properties {
		        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
		        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
		        public final static Property Age = new Property(2, int.class, "age", false, "AGE");
		        public final static Property Sex = new Property(3, String.class, "sex", false, "SEX");
		        public final static Property City = new Property(4, String.class, "city", false, "CITY");
		    }


		    public UserDao(DaoConfig config) {
		        super(config);
		    }

		    public UserDao(DaoConfig config, DaoSession daoSession) {
		        super(config, daoSession);
		    }

		    /** Creates the underlying database table. */
		    public static void createTable(Database db, boolean ifNotExists) {
		        String constraint = ifNotExists? "IF NOT EXISTS ": "";
		        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
		                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
		                "\"NAME\" TEXT," + // 1: name
		                "\"AGE\" INTEGER NOT NULL ," + // 2: age
		                "\"SEX\" TEXT," + // 3: sex
		                "\"CITY\" TEXT);"); // 4: city
		    }

		    /** Drops the underlying database table. */
		    public static void dropTable(Database db, boolean ifExists) {
		        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
		        db.execSQL(sql);
		    }

		    @Override
		    protected final void bindValues(DatabaseStatement stmt, User entity) {
		        stmt.clearBindings();

		        Long id = entity.getId();
		        if (id != null) {
		            stmt.bindLong(1, id);
		        }

		        String name = entity.getName();
		        if (name != null) {
		            stmt.bindString(2, name);
		        }
		        stmt.bindLong(3, entity.getAge());

		        String sex = entity.getSex();
		        if (sex != null) {
		            stmt.bindString(4, sex);
		        }

		        String city = entity.getCity();
		        if (city != null) {
		            stmt.bindString(5, city);
		        }
		    }

		    @Override
		    protected final void bindValues(SQLiteStatement stmt, User entity) {
		        stmt.clearBindings();

		        Long id = entity.getId();
		        if (id != null) {
		            stmt.bindLong(1, id);
		        }

		        String name = entity.getName();
		        if (name != null) {
		            stmt.bindString(2, name);
		        }
		        stmt.bindLong(3, entity.getAge());

		        String sex = entity.getSex();
		        if (sex != null) {
		            stmt.bindString(4, sex);
		        }

		        String city = entity.getCity();
		        if (city != null) {
		            stmt.bindString(5, city);
		        }
		    }

		    @Override
		    public Long readKey(Cursor cursor, int offset) {
		        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
		    }

		    @Override
		    public User readEntity(Cursor cursor, int offset) {
		        User entity = new User( //
		            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
		            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
		            cursor.getInt(offset + 2), // age
		            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sex
		            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // city
		        );
		        return entity;
		    }

		    @Override
		    public void readEntity(Cursor cursor, User entity, int offset) {
		        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
		        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
		        entity.setAge(cursor.getInt(offset + 2));
		        entity.setSex(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
		        entity.setCity(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
		     }

		    @Override
		    protected final Long updateKeyAfterInsert(User entity, long rowId) {
		        entity.setId(rowId);
		        return rowId;
		    }

		    @Override
		    public Long getKey(User entity) {
		        if(entity != null) {
		            return entity.getId();
		        } else {
		            return null;
		        }
		    }

		    @Override
		    public boolean hasKey(User entity) {
		        return entity.getId() != null;
		    }

		    @Override
		    protected final boolean isEntityUpdateable() {
		        return true;
		    }

		}


## 注解说明


	@Entity 用于标识这是一个需要Greendao帮我们生成代码的bean

	@Id 标明主键，括号里可以指定是否自增

	@Property 用于设置属性在数据库中的列名（默认不写就是保持一致）

	@NotNull 非空

	@Transient 标识这个字段是自定义的不会创建到数据库表里

	@Unique 添加唯一约束

	@ToOne 是将自己的一个属性与另一个表建立关联（外键）

	@ToMany的属性referencedJoinProperty，类似于外键约束。

	@JoinProperty 对于更复杂的关系，可以使用这个注解标明目标属性的源属性。





## 创建App


- 代码

		import android.app.Application;

		import com.maohuawei.greendao_unit1.gen.DaoMaster;
		import com.maohuawei.greendao_unit1.gen.DaoSession;

		import org.greenrobot.greendao.database.Database;

		/**
		 * Created by maohuawei on 2018/1/1.
		 */

		public class App extends Application {
		    public static final boolean ENCRYPTED = true;

		    private DaoSession daoSession;

		    @Override
		    public void onCreate() {
		        super.onCreate();

		        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "users-db-encrypted" : "users-db");
		        Database db = helper.getWritableDb();
		        daoSession = new DaoMaster(db).newSession();
		    }

		    public DaoSession getDaoSession() {
		        return daoSession;
		    }

		}


- 注册





- 代码


		//声明
	    private UserDao userDao;
	    private Query<User> userQuery;



		//实例化
        DaoSession daoSession = ((App) getApplication()).getDaoSession();

        userDao = daoSession.getUserDao();

        userQuery = userDao.queryBuilder().orderAsc(UserDao.Properties.Id).build();



- > 增加

 		userDao.insert(new User(null, "maohuawei", 22, "man", "beijing"));


- > 删除

		userDao.deleteByKey(1L);


- > 修改


		 User load = userDao.load(1L);
        load.setName("ms");
        userDao.update(load);

- > 查询


		// 查询全部数据

  		List<User> users = userQuery.list();


		// 根据属性查询

        QueryBuilder<User> builder = userDao.queryBuilder();
        Query<User> query = builder                 //姓名
                .where(UserDao.Properties.Name.eq("ms"),
                                                    //性别
                        UserDao.Properties.Sex.eq("man"))
                .build();
        List<User> list = query.list();



