package tiku.工作.楼宇卫视.根据时间查询列表;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-22
 **/
public class 根据时间查询列表 {

    public static void main(String[] args) {


//                StringBuffer sqlBuffer = new StringBuffer(" select t1.meter_id, t2.object_id as record_id, t2.reading_value, t2.reading_cost, t2.reading_user, t2.reading_time, t2.peak_reading, " +
//                        " t2.peak_cost, t2.peak_section_reading, t2.peak_section_cost, t2.average_reading, t2.average_cost, t2.low_valley_reading, t2.low_valley_cost, " +
//                        " t3.meter_code, t3.meter_name, t3.install_space_id, t3.mom_ratio, t4.plan_type as price_type " +
//                        " FROM meter_order_meter_ref t1   " +
//                        " LEFT JOIN ( " +
//                        " SELECT tt1.* FROM meter_order_record tt1 WHERE tt1.create_time IN (SELECT MAX(create_time) FROM meter_order_record "+
//                        " WHERE 1=1 AND project_id = ? and meter_id in( ");
//                args.add(projectId);
//                for (String meterId: meterIds) {
//                    sqlBuffer.append("?,");
//                    args.add(meterId);
//                }
//                sqlBuffer.delete(sqlBuffer.length()-1, sqlBuffer.length());
//                sqlBuffer.append(")");
//
//                sqlBuffer.append(" GROUP BY meter_id )) AS t2 on  t1.meter_id = t2.meter_id");
//
//                if (EnergyTypeEnum.ENERGY_ELE.getEnergyType().equals(energyType)) {
//                    sqlBuffer.append(" LEFT JOIN meter_electric t3 ON t3.object_id=t1.meter_id");
//                } else if (EnergyTypeEnum.ENERGY_WATER.getEnergyType().equals(energyType)) {
//                    sqlBuffer.append(" LEFT JOIN meter_water t3 ON t3.object_id=t1.meter_id ");
//                } else if (EnergyTypeEnum.ENERGY_GAS.getEnergyType().equals(energyType)) {
//                    sqlBuffer.append(" LEFT JOIN meter_gas t3 ON t3.object_id=t1.meter_id");
//                } else if (EnergyTypeEnum.ENERGY_HOT.getEnergyType().equals(energyType)) {
//                    sqlBuffer.append(" LEFT JOIN meter_hot_energy t3 ON t3.object_id=t1.meter_id ");
//                }
//
//                sqlBuffer.append(" LEFT JOIN meter_price_plan t4 on t3.price_plan_id= t4.object_id  ");
//                sqlBuffer.append(" WHERE t1.active = 1 and t1.project_id=? and t3.project_id=? and t4.project_id = ?");
//                args.add(projectId);
//                args.add(projectId);
//                args.add(projectId);
//
//                sqlBuffer.append("  and t1.meter_id in( ");
//                for (String meterId: meterIds) {
//                    sqlBuffer.append("?,");
//                    args.add(meterId);
//                }
//                sqlBuffer.delete(sqlBuffer.length()-1, sqlBuffer.length());
//                sqlBuffer.append(")");
//
//                sqlBuffer.append("  GROUP BY t1.meter_id ");
//                recordVOS = baseJdbcDao.queryForList(sqlBuffer.toString(), args.toArray(), AppMeterRecordVO.class);

    }
}
