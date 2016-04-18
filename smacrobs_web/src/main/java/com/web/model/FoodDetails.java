package com.web.model;

public class FoodDetails
{
    private Summary summary;

    private Foods[] foods;

    public Summary getSummary ()
    {
        return summary;
    }

    public void setSummary (Summary summary)
    {
        this.summary = summary;
    }

    public Foods[] getFoods ()
    {
        return foods;
    }

    public void setFoods (Foods[] foods)
    {
        this.foods = foods;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [summary = "+summary+", foods = "+foods+"]";
    }
    
    public class Summary
    {
        private String water;

        private String protein;

        private String fat;

        private String calories;

        private String sodium;

        private String fiber;

        private String carbs;

        public String getWater ()
        {
            return water;
        }

        public void setWater (String water)
        {
            this.water = water;
        }

        public String getProtein ()
        {
            return protein;
        }

        public void setProtein (String protein)
        {
            this.protein = protein;
        }

        public String getFat ()
        {
            return fat;
        }

        public void setFat (String fat)
        {
            this.fat = fat;
        }

        public String getCalories ()
        {
            return calories;
        }

        public void setCalories (String calories)
        {
            this.calories = calories;
        }

        public String getSodium ()
        {
            return sodium;
        }

        public void setSodium (String sodium)
        {
            this.sodium = sodium;
        }

        public String getFiber ()
        {
            return fiber;
        }

        public void setFiber (String fiber)
        {
            this.fiber = fiber;
        }

        public String getCarbs ()
        {
            return carbs;
        }

        public void setCarbs (String carbs)
        {
            this.carbs = carbs;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [water = "+water+", protein = "+protein+", fat = "+fat+", calories = "+calories+", sodium = "+sodium+", fiber = "+fiber+", carbs = "+carbs+"]";
        }
    }
    
    	
    
    public class Unit
    {
        private String id;

        private String name;

        private String plural;

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getPlural ()
        {
            return plural;
        }

        public void setPlural (String plural)
        {
            this.plural = plural;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [id = "+id+", name = "+name+", plural = "+plural+"]";
        }
    }
    
    public class Foods
    {
        private LoggedFood loggedFood;

        private String logId;

        private String isFavorite;

        private NutritionalValues nutritionalValues;

        private String logDate;

        public LoggedFood getLoggedFood ()
        {
            return loggedFood;
        }

        public void setLoggedFood (LoggedFood loggedFood)
        {
            this.loggedFood = loggedFood;
        }

        public String getLogId ()
        {
            return logId;
        }

        public void setLogId (String logId)
        {
            this.logId = logId;
        }

        public String getIsFavorite ()
        {
            return isFavorite;
        }

        public void setIsFavorite (String isFavorite)
        {
            this.isFavorite = isFavorite;
        }

        public NutritionalValues getNutritionalValues ()
        {
            return nutritionalValues;
        }

        public void setNutritionalValues (NutritionalValues nutritionalValues)
        {
            this.nutritionalValues = nutritionalValues;
        }

        public String getLogDate ()
        {
            return logDate;
        }

        public void setLogDate (String logDate)
        {
            this.logDate = logDate;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [loggedFood = "+loggedFood+", logId = "+logId+", isFavorite = "+isFavorite+", nutritionalValues = "+nutritionalValues+", logDate = "+logDate+"]";
        }
    }
    
    public class NutritionalValues
    {
        private String protein;

        private String fat;

        private String calories;

        private String sodium;

        private String fiber;

        private String carbs;

        public String getProtein ()
        {
            return protein;
        }

        public void setProtein (String protein)
        {
            this.protein = protein;
        }

        public String getFat ()
        {
            return fat;
        }

        public void setFat (String fat)
        {
            this.fat = fat;
        }

        public String getCalories ()
        {
            return calories;
        }

        public void setCalories (String calories)
        {
            this.calories = calories;
        }

        public String getSodium ()
        {
            return sodium;
        }

        public void setSodium (String sodium)
        {
            this.sodium = sodium;
        }

        public String getFiber ()
        {
            return fiber;
        }

        public void setFiber (String fiber)
        {
            this.fiber = fiber;
        }

        public String getCarbs ()
        {
            return carbs;
        }

        public void setCarbs (String carbs)
        {
            this.carbs = carbs;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [protein = "+protein+", fat = "+fat+", calories = "+calories+", sodium = "+sodium+", fiber = "+fiber+", carbs = "+carbs+"]";
        }
    }
    
    public class LoggedFood
    {
        private String amount;

        private Unit unit;

        private String foodId;

        private String name;

        private String calories;

        private String brand;

        private String mealTypeId;

        private String accessLevel;

        private String[] units;

        public String getAmount ()
        {
            return amount;
        }

        public void setAmount (String amount)
        {
            this.amount = amount;
        }

        public Unit getUnit ()
        {
            return unit;
        }

        public void setUnit (Unit unit)
        {
            this.unit = unit;
        }

        public String getFoodId ()
        {
            return foodId;
        }

        public void setFoodId (String foodId)
        {
            this.foodId = foodId;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getCalories ()
        {
            return calories;
        }

        public void setCalories (String calories)
        {
            this.calories = calories;
        }

        public String getBrand ()
        {
            return brand;
        }

        public void setBrand (String brand)
        {
            this.brand = brand;
        }

        public String getMealTypeId ()
        {
            return mealTypeId;
        }

        public void setMealTypeId (String mealTypeId)
        {
            this.mealTypeId = mealTypeId;
        }

        public String getAccessLevel ()
        {
            return accessLevel;
        }

        public void setAccessLevel (String accessLevel)
        {
            this.accessLevel = accessLevel;
        }

        public String[] getUnits ()
        {
            return units;
        }

        public void setUnits (String[] units)
        {
            this.units = units;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [amount = "+amount+", unit = "+unit+", foodId = "+foodId+", name = "+name+", calories = "+calories+", brand = "+brand+", mealTypeId = "+mealTypeId+", accessLevel = "+accessLevel+", units = "+units+"]";
        }
    }
    	
}
