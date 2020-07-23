package com.lambdashane.newzoo.repository;

import com.lambdashane.newzoo.models.Zoo;
import com.lambdashane.newzoo.views.AnimalCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZooRepository extends CrudRepository<Zoo, Long>
{

}
//    SELECT e.name as employee_name, count(et.employeeid)
//    as count_job_titles FROM employees e LEFT JOIN employeetitles
//    et ON e.employeeid = et.employeeid GROUP BY e.name