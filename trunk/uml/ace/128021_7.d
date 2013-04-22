format 76

classcanvas 128021 class_ref 128021 // Cliente
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 89 101 2000
end
classcanvas 128149 class_ref 128149 // Usuario
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 227 100 2000
end
classcanvas 128277 class_ref 128277 // PreferenciasUsuario
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 306 17 2000
end
classcanvas 128661 class_ref 128405 // RegistroUsuarios
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 355 172 2000
end
classcanvas 128917 class_ref 128533 // Vuelo
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 592 178 2000
end
classcanvas 129045 class_ref 128661 // Oferta
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 482 279 2000
end
classcanvas 129301 class_ref 128789 // Aeropuerto
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 725 254 2000
end
classcanvas 129557 class_ref 128917 // RegistroVuelos
  draw_all_relations default hide_attributes default hide_operations default hide_getset_operations default show_members_full_definition default show_members_visibility default show_members_stereotype default show_members_context default show_members_multiplicity default show_members_initialization default show_attribute_modifiers default member_max_width 0 show_parameter_dir default show_parameter_name default package_name_in_tab default class_drawing_mode default drawing_language default show_context_mode default auto_label_position default show_relation_modifiers default show_relation_visibility default show_infonote default shadow default show_stereotype_properties default
  xyz 639 68 2000
end
relationcanvas 128405 relation_ref 128021 // <directional aggregation>
  from ref 128149 z 2001 to ref 128277
  no_role_a no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 128533 relation_ref 128149 // <association>
  from ref 128021 z 2001 to ref 128149
  no_role_a no_role_b
  multiplicity_a_pos 207 134 3000 multiplicity_b_pos 167 134 3000
end
relationcanvas 128789 relation_ref 128277 // <directional aggregation>
  decenter_begin 59
  from ref 128661 z 2001 to ref 128149
  no_role_a no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 129173 relation_ref 128405 // <association>
  from ref 128917 z 2001 to ref 129045
  no_role_a no_role_b
  multiplicity_a_pos 546 280 3000 multiplicity_b_pos 557 226 3000
end
relationcanvas 129429 relation_ref 128533 // <association>
  from ref 129301 z 2001 to ref 128917
  no_role_a no_role_b
  multiplicity_a_pos 658 229 3000 multiplicity_b_pos 709 268 3000
end
relationcanvas 129685 relation_ref 128661 // <aggregation>
  from ref 129557 z 2001 to ref 128917
  no_role_a no_role_b
  no_multiplicity_a no_multiplicity_b
end
end
